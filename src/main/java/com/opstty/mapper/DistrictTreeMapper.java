package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class DistrictTreeMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        StringTokenizer itr = new StringTokenizer(value.toString(), ";");
        // drop GEOLOCALISATION column
        itr.nextToken();

        String district = itr.nextToken();
        if (district.equals("ARRONDISSEMENT"))
        {
            return;
        }
        word.set(district);
        context.write(word, one);
    }
}
