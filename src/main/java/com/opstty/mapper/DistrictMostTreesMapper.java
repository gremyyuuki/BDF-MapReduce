package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class DistrictMostTreesMapper extends Mapper<Object, Text, Text, IntWritable> {
    private Text word = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        StringTokenizer itr = new StringTokenizer(value.toString(), "\t ");
        String district = itr.nextToken();
        word.set(district);

        int count = new Integer(itr.nextToken());

        context.write(word, new IntWritable(count));
    }
}
