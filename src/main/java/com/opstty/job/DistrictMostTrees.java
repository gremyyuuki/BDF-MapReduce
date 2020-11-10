package com.opstty.job;

import com.opstty.mapper.DistrictMostTreesMapper;
import com.opstty.mapper.DistrictTreeMapper;
import com.opstty.reducer.DistricTreeReducer;
import com.opstty.reducer.DistrictMostTreesReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class DistrictMostTrees
{
    public static void main(String[] args) throws Exception
    {
        Configuration conf1 = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf1, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: districtmosttrees <in> [<in>...] <out>");
            System.exit(2);
        }

        // First job will count the number of trees in each district
        Job job1 = Job.getInstance(conf1, "districttreessum");
        job1.setJarByClass(DistrictMostTrees.class);
        job1.setMapperClass(DistrictTreeMapper.class);
        job1.setCombinerClass(DistricTreeReducer.class);
        job1.setReducerClass(DistricTreeReducer.class);
        job1.setOutputKeyClass(Text.class);
        job1.setOutputValueClass(IntWritable.class);

        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job1, new Path(otherArgs[i]));
        }

        String outputDir = otherArgs[otherArgs.length - 1];
        String tempPath = new Path(outputDir).getParent().getName() + "/temp" ;
        Path tempDir = new Path(tempPath);
        FileOutputFormat.setOutputPath(job1, tempDir);

        job1.waitForCompletion(true);

        // Job 2 will find the district with the most trees
        Configuration conf2 = new Configuration();
        Job job2 = Job.getInstance(conf2, "districtmosttrees");

        job2.setJarByClass(DistrictMostTrees.class);
        job2.setMapperClass(DistrictMostTreesMapper.class);
        job2.setCombinerClass(DistrictMostTreesReducer.class);
        job2.setReducerClass(DistrictMostTreesReducer.class);
        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job2, new Path(tempPath + "/part-r-00000"));
        FileOutputFormat.setOutputPath(job2, new Path(outputDir));

        // Delete temp folder.
        // tempDir.getFileSystem(conf1).deleteOnExit(tempDir);

        System.exit(job2.waitForCompletion(true) ? 0 : 1);
    }
}
