echo "各个TAG题目数量："
find ../ -type f | awk -F/ '{
    if (NF > 3) {
        dir = $4;  # 取二级目录
        count[dir]++;
    }
} END {
    for (d in count) {
        print " " d ":" count[d];
    }
}' | sort -t: -k2,2nr | head -n 10

echo "总题目数"

find . -type f -name "*.java" | wc -l
