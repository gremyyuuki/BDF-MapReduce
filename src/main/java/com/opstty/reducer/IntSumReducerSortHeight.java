package com.opstty.reducer;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class IntSumReducerSortHeight extends Reducer<DoubleWritable, Text, DoubleWritable, Text> {
    private Text result = new Text();

    public void reduce(DoubleWritable key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        // get the name of the tree
        for (Text t: values)
        {
            context.write(key, t);
        }
    }
}
