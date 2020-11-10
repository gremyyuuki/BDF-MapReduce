package com.opstty.mapper;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortHeightMapper extends Mapper<Object, Text, DoubleWritable, Text> {
    private final static Text one = new Text("1");
    private DoubleWritable word = new DoubleWritable();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] itr = value.toString().split(";");

        // fill empty values with _
        for (int i = 0; i < itr.length; i += 1) {
            if (itr[i].equals("HAUTEUR")) {
                return;
            }
            if (itr[i].length() == 0 || equals("")) {
                itr[i] = "_";
            }
        }
        
        Double height;

        try {
            height = new Double(Double.parseDouble(itr[6]));
        } catch (NumberFormatException e) {
            return;
        }

        word.set(height);
        one.set(itr[2]);
        context.write(word, one);
    }
}
