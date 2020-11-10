package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class KindMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        StringTokenizer itr = new StringTokenizer(value.toString(), ";");
        // drop GEOLOCALISATION and ARRONDISSEMENT columns
        itr.nextToken();
        itr.nextToken();

        String kind = itr.nextToken();
        if (kind.equals("GENRE"))
        {
            return;
        }
        word.set(kind);
        context.write(word, one);
    }
}
