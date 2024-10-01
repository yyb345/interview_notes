find ../leetcode -type f | awk -F/ '{
    dir = $0;
    sub("/[^/]+$", "", dir);
    count[dir]++;
} END {
    for (d in count) {
        print d ": " count[d];
    }
}'


find ../leetcode -type f | wc -l