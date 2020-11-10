Florian Ernst - Jérémy Trullier

M2 Promo 2021

Efrei Paris Big Data & Machine Learning



# Big Data Frameworks

# Lab MapReduce Java



This report contains the commands and outputs we got for our lab about MapReduce in java.

The goal was to implement some MapReduce jobs to explore some information in a dataset about the trees of Paris.

The results of the MapReduce jobs will be written in the lab3results directory on HDFS.

Launch the custom commands contained in the .jar file generated from our java code.

### 1.8.1 Districts containing trees

Job command:

`yarn jar /home/jtrullier/hadoop-examples-mapreduce-1.0-186-jar-with-dependencies.jar districttree trees.csv lab3results/district`

Here is the ouptut:

`20/11/07 18:24:02INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200`
`20/11/07 18:24:02 INFO hdfs.DFSClient: Created token for jtrullier: HDFS_DELEGATION_TOKEN owner=jtrullier@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604769842426, maxDate=1605374642426, sequenceNumber=4769, masterKeyId=43 on ha-hdfs:efrei`
`20/11/07 18:24:02 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for jtrullier: HDFS_DELEGATION_TOKEN owner=jtrullier@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604769842426, maxDate=1605374642426, sequenceNumber=4769, masterKeyId=43)`
`20/11/07 18:24:02 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/jtrullier/.staging/job_1603290159664_2573`
`20/11/07 18:24:03 INFO input.FileInputFormat: Total input files to process : 1`
`20/11/07 18:24:03 INFO mapreduce.JobSubmitter: number of splits:1`
`20/11/07 18:24:03 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2573`
`20/11/07 18:24:03 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for jtrullier: HDFS_DELEGATION_TOKEN owner=jtrullier@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604769842426, maxDate=1605374642426, sequenceNumber=4769, masterKeyId=43)]`
`20/11/07 18:24:03 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml`
`20/11/07 18:24:03 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190`
`20/11/07 18:24:04 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2573`
`20/11/07 18:24:04 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2573/`
`20/11/07 18:24:04 INFO mapreduce.Job: Running job: job_1603290159664_2573`
`20/11/07 18:24:14 INFO mapreduce.Job: Job job_1603290159664_2573 running in uber mode : false`
`20/11/07 18:24:14 INFO mapreduce.Job:  map 0% reduce 0%`
`20/11/07 18:24:23 INFO mapreduce.Job:  map 100% reduce 0%`
`20/11/07 18:24:32 INFO mapreduce.Job:  map 100% reduce 100%`
`20/11/07 18:24:32 INFO mapreduce.Job: Job job_1603290159664_2573 completed successfully`
`20/11/07 18:24:32 INFO mapreduce.Job: Counters: 53`
        `File System Counters`
                `FILE: Number of bytes read=152`
                `FILE: Number of bytes written=493563`
                `FILE: Number of read operations=0`
                `FILE: Number of large read operations=0`
                `FILE: Number of write operations=0`
                `HDFS: Number of bytes read=16880`
                `HDFS: Number of bytes written=80`
                `HDFS: Number of read operations=8`
                `HDFS: Number of large read operations=0`
                `HDFS: Number of write operations=2`
        `Job Counters`
                `Launched map tasks=1`
                `Launched reduce tasks=1`
                `Data-local map tasks=1`
                `Total time spent by all maps in occupied slots (ms)=20574`
                `Total time spent by all reduces in occupied slots (ms)=27788`
                `Total time spent by all map tasks (ms)=6858`
                `Total time spent by all reduce tasks (ms)=6947`
                `Total vcore-milliseconds taken by all map tasks=6858`
                `Total vcore-milliseconds taken by all reduce tasks=6947`
                `Total megabyte-milliseconds taken by all map tasks=10533888`
                `Total megabyte-milliseconds taken by all reduce tasks=14227456`
        `Map-Reduce Framework`
                `Map input records=98`
                `Map output records=97`
                `Map output bytes=665`
                `Map output materialized bytes=152`
                `Input split bytes=102`
                `Combine input records=97`
                `Combine output records=17`
                `Reduce input groups=17`
                `Reduce shuffle bytes=152`
                `Reduce input records=17`
                `Reduce output records=17`
                `Spilled Records=34`
                `Shuffled Maps =1`
                `Failed Shuffles=0`
                `Merged Map outputs=1`
                `GC time elapsed (ms)=224`
                `CPU time spent (ms)=3430`
                `Physical memory (bytes) snapshot=1450090496`
                `Virtual memory (bytes) snapshot=7266488320`
                `Total committed heap usage (bytes)=1563426816`
                `Peak Map Physical memory (bytes)=1156489216`
                `Peak Map Virtual memory (bytes)=3393499136`
                `Peak Reduce Physical memory (bytes)=293601280`
                `Peak Reduce Virtual memory (bytes)=3872989184`
        `Shuffle Errors`
                `BAD_ID=0`
                `CONNECTION=0`
                `IO_ERROR=0`
                `WRONG_LENGTH=0`
                `WRONG_MAP=0`
                `WRONG_REDUCE=0`
        `File Input Format Counters`
                `Bytes Read=16778`
        `File Output Format Counters
                Bytes Written=80`

Now let's cat the file to see the real result.

`hdfs dfs -cat lab3results/district/part-r-00000`

Output:

`11      1`
`12      29`
`13      2`
`14      3`
`15      1`
`16      36`
`17      1`
`18      1`
`19      6`
`20      3`
`3       1`
`4       1`
`5       2`
`6       1`
`7       3`
`8       5`
`9       1`

The districts 1,2 and 10 don't have trees recorded in this file.



### 1.8.2 Show all existing species

Job command:

`yarn jar /home/jtrullier/hadoop-examples-mapreduce-1.0-186-jar-with-dependencies.jar species trees.csv lab3results/species`

Job output (shortened):

    20/11/07 18:48:14 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/07 18:48:23 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/07 18:48:34 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/07 18:48:34 INFO mapreduce.Job: Job job_1603290159664_2577 completed successfully
    20/11/07 18:48:34 INFO mapreduce.Job: Counters: 53
        File Output Format Counters
                Bytes Written=542
Result command:

`hdfs dfs -cat lab3results/species/part-r-00000`

Result output:

`araucana        1
atlantica       2
australis       1
baccata 2
bignonioides    1
biloba  5
bungeana        1
cappadocicum    1
carpinifolia    4
colurna 3
coulteri        1
decurrens       1
dioicus 1
distichum       3
excelsior       1
fraxinifolia    2
giganteum       5
giraldii        1
glutinosa       1
grandiflora     1
hippocastanum   3
ilex    1
involucrata     1
japonicum       1
kaki    2
libanii 2
monspessulanum  1
nigra   3
nigra laricio   1
opalus  1
orientalis      8
papyrifera      1
petraea 2
pomifera        1
pseudoacacia    1
sempervirens    1
serrata 1
stenoptera      1
suber   1
sylvatica       8
tomentosa       2
tulipifera      2
ulmoides        1
virginiana      2
x acerifolia    11`



### 1.8.3 Number of trees by species

Job command:

`yarn jar /home/jtrullier/hadoop-examples-mapreduce-1.0-186-jar-with-dependencies.jar kind trees.csv lab3results/kind`

Job output (shortened):

    20/11/07 18:48:14 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/07 18:48:23 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/07 18:48:34 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/07 18:48:34 INFO mapreduce.Job: Job job_1603290159664_2579 completed successfully
    20/11/07 18:48:34 INFO mapreduce.Job: Counters: 53
        File Output Format Counters
                Bytes Written=390

Result command:

`hdfs dfs -cat lab3results/kind/part-r-00000`

Result output:

`Acer    3
Aesculus        3
Ailanthus       1
Alnus   1
Araucaria       1
Broussonetia    1
Calocedrus      1
Catalpa 1
Cedrus  4
Celtis  1
Corylus 3
Davidia 1
Diospyros       4
Eucommia        1
Fagus   8
Fraxinus        1
Ginkgo  5
Gymnocladus     1
Juglans 1
Liriodendron    2
Maclura 1
Magnolia        1
Paulownia       1
Pinus   5
Platanus        19
Pterocarya      3
Quercus 4
Robinia 1
Sequoia 1
Sequoiadendron  5
Styphnolobium   1
Taxodium        3
Taxus   2
Tilia   1
Ulmus   1
Zelkova 4`



### 1.8.4 Maximum height per specie of tree

Job command:

`yarn jar /home/jtrullier/hadoop-examples-mapreduce-1.0-186-jar-with-dependencies.jar maxheight trees.csv lab3results/maxheight`

Job output (shortened):

    20/11/07 18:48:14 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/07 18:48:23 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/07 18:48:34 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/07 18:48:34 INFO mapreduce.Job: Job job_1603290159664_2580 completed successfully
    20/11/07 18:48:34 INFO mapreduce.Job: Counters: 53
        File Output Format Counters
                Bytes Written=424

Result command:

`hdfs dfs -cat lab3results/maxheight/part-r-00000`

Result output:

`Acer    16
Aesculus        30
Ailanthus       35
Alnus   16
Araucaria       9
Broussonetia    12
Calocedrus      20
Catalpa 15
Cedrus  30
Celtis  16
Corylus 20
Davidia 12
Diospyros       14
Eucommia        12
Fagus   30
Fraxinus        30
Ginkgo  33
Gymnocladus     10
Juglans 28
Liriodendron    35
Maclura 13
Magnolia        12
Paulownia       20
Pinus   30
Platanus        45
Pterocarya      30
Quercus 31
Robinia 11
Sequoia 30
Sequoiadendron  35
Styphnolobium   10
Taxodium        35
Taxus   13
Tilia   20
Ulmus   15
Zelkova 30`



### 1.8.5 Sort the trees height from smallest to largest

Job command:

`yarn jar /home/jtrullier/hadoop-examples-mapreduce-1.0-186-jar-with-dependencies.jar sortheight trees.csv lab3results/sortheight`

Job output (shortened):

    20/11/07 18:48:14 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/07 18:48:23 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/07 18:48:34 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/07 18:48:34 INFO mapreduce.Job: Job job_1603290159664_2582 completed successfully
    20/11/07 18:48:34 INFO mapreduce.Job: Counters: 53
        File Output Format Counters
                Bytes Written=1296

Result command:

`hdfs dfs -cat lab3results/sortheight/part-r-00000`

Result output:

`2.0     Fagus
5.0     Taxus
6.0     Cedrus
9.0     Araucaria
10.0    Styphnolobium
10.0    Quercus
10.0    Pinus
10.0    Gymnocladus
10.0    Fagus
11.0    Robinia
12.0    Diospyros
12.0    Magnolia
12.0    Zelkova
12.0    Eucommia
12.0    Acer
12.0    Diospyros
12.0    Broussonetia
12.0    Davidia
13.0    Taxus
13.0    Maclura
14.0    Diospyros
14.0    Pinus
14.0    Diospyros
15.0    Acer
15.0    Catalpa
15.0    Fagus
15.0    Ulmus
15.0    Quercus
16.0    Alnus
16.0    Acer
16.0    Zelkova
16.0    Celtis
18.0    Ginkgo
18.0    Zelkova
18.0    Aesculus
18.0    Fagus
20.0    Corylus
20.0    Platanus
20.0    Tilia
20.0    Corylus
20.0    Calocedrus
20.0    Corylus
20.0    Platanus
20.0    Fagus
20.0    Paulownia
20.0    Sequoiadendron
20.0    Taxodium
20.0    Platanus
22.0    Ginkgo
22.0    Aesculus
22.0    Platanus
22.0    Pterocarya
22.0    Liriodendron
23.0    Fagus
25.0    Cedrus
25.0    Ginkgo
25.0    Platanus
25.0    Platanus
25.0    Pinus
25.0    Ginkgo
26.0    Platanus
27.0    Pterocarya
27.0    Platanus
28.0    Juglans
30.0    Pinus
30.0    Quercus
30.0    Sequoiadendron
30.0    Pterocarya
30.0    Zelkova
30.0    Sequoia
30.0    Fagus
30.0    Platanus
30.0    Taxodium
30.0    Platanus
30.0    Pinus
30.0    Fagus
30.0    Sequoiadendron
30.0    Fraxinus
30.0    Cedrus
30.0    Cedrus
30.0    Aesculus
31.0    Quercus
31.0    Platanus
32.0    Platanus
33.0    Ginkgo
34.0    Platanus
35.0    Taxodium
35.0    Liriodendron
35.0    Platanus
35.0    Ailanthus
35.0    Sequoiadendron
40.0    Platanus
40.0    Platanus
40.0    Platanus
42.0    Platanus
45.0    Platanus`



### 1.8.6 District containing the oldest tree

Job command:

`yarn jar /home/jtrullier/hadoop-examples-mapreduce-1.0-186-jar-with-dependencies.jar oldtree trees.csv lab3results/oldtree`

Job output (shortened):

    20/11/07 18:48:14 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/07 18:48:23 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/07 18:48:34 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/07 18:48:34 INFO mapreduce.Job: Job job_1603290159664_2585 completed successfully
    20/11/07 18:48:34 INFO mapreduce.Job: Counters: 53
        File Output Format Counters
                Bytes Written=6

Result command:

`hdfs dfs -cat lab3results/oldtree/part-r-00000`

Result output:

`5       419`

### 1.8.7 District containing the most trees

This one was more complicated. There are 2 Map/Reduce processes going on here.

Therefore, we put the whole log to show the entire process.
```
[fernst@hadoop-edge01 ~]$ yarn jar /home/fernst/hadoop-examples-mapreduce-1.0-187-jar-with-dependencies.jar districtmosttrees trees.csv lab3results/mosttrees

20/11/10 19:04:56 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 19:04:56 INFO hdfs.DFSClient: Created token for fernst: HDFS_DELEGATION_TOKEN owner=fernst@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605031496527, maxDate=1605636296527, sequenceNumber=5958, masterKeyId=46 on ha-hdfs:efrei
20/11/10 19:04:56 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for fernst: HDFS_DELEGATION_TOKEN owner=fernst@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605031496527, maxDate=1605636296527, sequenceNumber=5958, masterKeyId=46)
20/11/10 19:04:56 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/fernst/.staging/job_1603290159664_3508
20/11/10 19:04:57 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 19:04:57 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 19:04:57 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3508
20/11/10 19:04:57 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for fernst: HDFS_DELEGATION_TOKEN owner=fernst@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605031496527, maxDate=1605636296527, sequenceNumber=5958, masterKeyId=46)]
20/11/10 19:04:57 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/10 19:04:57 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 19:04:58 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3508
20/11/10 19:04:58 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3508/
20/11/10 19:04:58 INFO mapreduce.Job: Running job: job_1603290159664_3508
20/11/10 19:05:09 INFO mapreduce.Job: Job job_1603290159664_3508 running in uber mode : false
20/11/10 19:05:09 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 19:05:18 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 19:05:27 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 19:05:27 INFO mapreduce.Job: Job job_1603290159664_3508 completed successfully
20/11/10 19:05:27 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=152
                FILE: Number of bytes written=493481
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=17088
                HDFS: Number of bytes written=80
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=21288
                Total time spent by all reduces in occupied slots (ms)=27260
                Total time spent by all map tasks (ms)=7096
                Total time spent by all reduce tasks (ms)=6815
                Total vcore-milliseconds taken by all map tasks=7096
                Total vcore-milliseconds taken by all reduce tasks=6815
                Total megabyte-milliseconds taken by all map tasks=10899456
                Total megabyte-milliseconds taken by all reduce tasks=13957120
        Map-Reduce Framework
                Map input records=99
                Map output records=98
                Map output bytes=672
                Map output materialized bytes=152
                Input split bytes=99
                Combine input records=98
                Combine output records=17
                Reduce input groups=17
                Reduce shuffle bytes=152
                Reduce input records=17
                Reduce output records=17
                Spilled Records=34
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=198
                CPU time spent (ms)=3030
                Physical memory (bytes) snapshot=1448607744
                Virtual memory (bytes) snapshot=7267921920
                Total committed heap usage (bytes)=1548746752
                Peak Map Physical memory (bytes)=1157652480
                Peak Map Virtual memory (bytes)=3393564672
                Peak Reduce Physical memory (bytes)=290955264
                Peak Reduce Virtual memory (bytes)=3874357248
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters
                Bytes Read=16989
        File Output Format Counters
                Bytes Written=80
20/11/10 19:05:28 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 19:05:28 INFO hdfs.DFSClient: Created token for fernst: HDFS_DELEGATION_TOKEN owner=fernst@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605031528025, maxDate=1605636328025, sequenceNumber=5960, masterKeyId=46 on ha-hdfs:efrei
20/11/10 19:05:28 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for fernst: HDFS_DELEGATION_TOKEN owner=fernst@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605031528025, maxDate=1605636328025, sequenceNumber=5960, masterKeyId=46)
20/11/10 19:05:28 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
20/11/10 19:05:28 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/fernst/.staging/job_1603290159664_3510
20/11/10 19:05:28 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 19:05:28 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 19:05:28 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3510
20/11/10 19:05:28 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for fernst: HDFS_DELEGATION_TOKEN owner=fernst@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605031528025, maxDate=1605636328025, sequenceNumber=5960, masterKeyId=46)]
20/11/10 19:05:28 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 19:05:29 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3510
20/11/10 19:05:29 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3510/
20/11/10 19:05:29 INFO mapreduce.Job: Running job: job_1603290159664_3510
20/11/10 19:05:39 INFO mapreduce.Job: Job job_1603290159664_3510 running in uber mode : false
20/11/10 19:05:39 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 19:05:48 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 19:05:54 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 19:05:54 INFO mapreduce.Job: Job job_1603290159664_3510 completed successfully
20/11/10 19:05:54 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=15
                FILE: Number of bytes written=492947
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=199
                HDFS: Number of bytes written=6
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=20436
                Total time spent by all reduces in occupied slots (ms)=11580
                Total time spent by all map tasks (ms)=6812
                Total time spent by all reduce tasks (ms)=2895
                Total vcore-milliseconds taken by all map tasks=6812
                Total vcore-milliseconds taken by all reduce tasks=2895
                Total megabyte-milliseconds taken by all map tasks=10463232
                Total megabyte-milliseconds taken by all reduce tasks=5928960
        Map-Reduce Framework
                Map input records=17
                Map output records=17
                Map output bytes=112
                Map output materialized bytes=15
                Input split bytes=119
                Combine input records=17
                Combine output records=1
                Reduce input groups=1
                Reduce shuffle bytes=15
                Reduce input records=1
                Reduce output records=1
                Spilled Records=2
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=208
                CPU time spent (ms)=3110
                Physical memory (bytes) snapshot=1449603072
                Virtual memory (bytes) snapshot=7268323328
                Total committed heap usage (bytes)=1552416768
                Peak Map Physical memory (bytes)=1154482176
                Peak Map Virtual memory (bytes)=3394228224
                Peak Reduce Physical memory (bytes)=295120896
                Peak Reduce Virtual memory (bytes)=3874095104
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters
                Bytes Read=80
        File Output Format Counters
                Bytes Written=6

[fernst@hadoop-edge01 ~]$ hdfs dfs -cat lab3results/mosttrees/part-r-00000
16      36
```

### Remarks

Sometimes the asignment told us to return or ignore the values and focus on doing operations on the keys, so we returned the values as well but they are not useful.