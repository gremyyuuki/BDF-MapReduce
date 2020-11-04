package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.yarn.webapp.hamlet2.Hamlet;

import java.io.IOException;
import java.util.StringTokenizer;

public class TokenizerMapperMaxHeight extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] itr = value.toString().split(";");

        // fill empty values with _
        for (int i = 0; i < itr.length; i += 1) {
            if (itr[i].equals("GENRE")) {
                return;
            }
            if (itr[i].length() == 0 || equals("")) {
                itr[i] = "_";
            }
        }

        // if value of height is empty, then return (ignore)
        Float heightF = null;
        try {
            heightF = new Float(Float.parseFloat(itr[6]));
        } catch (NumberFormatException e) {
            return;
        }

        // convert to IntWritable
        int heightI = Math.round(heightF);
        IntWritable height = new IntWritable(heightI);

        word.set(itr[2]);
        context.write(word, height);
    }
}
