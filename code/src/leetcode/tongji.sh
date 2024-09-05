find ../leetcode/ -type f | awk -F/ '{
    dir = $0;
    sub("/[^/]+$", "", dir);
    count[dir]++;
} END {
    for (d in count) {
        print d ": " count[d];
    }
}' | sort -t: -k2 -nr