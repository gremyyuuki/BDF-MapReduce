package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.VIntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class DistrictOldestTreeReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    protected IntWritable max = new IntWritable(0);
    protected Text district = new Text("0");

    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // find the oldest tree
        for (IntWritable value : values)
        {
            if (value.get() > max.get())
            {
                max.set(value.get());
                district.set(key);
            }
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        context.write(district, max);
    }
}