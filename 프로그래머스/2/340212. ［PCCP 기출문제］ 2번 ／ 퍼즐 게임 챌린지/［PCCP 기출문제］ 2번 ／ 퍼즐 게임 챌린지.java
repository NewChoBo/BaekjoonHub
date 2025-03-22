class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // n개의 퍼즐 시간 내에
        // 숙련도에 따라 틀리는 횟수 변함
        // 현재 난이도: diff
        // 현재 퍼즐 소요시간: time_cur
        // 이전 퍼즐 소요시간: time_prev
        // 내 숙련도: level

        // 1. 각 레벨 당 문제를 푸는 데 걸리는 시간 공식 만들기
        // 2. 레벨을 이진트리 탐색하듯이 좁혀나가기
        int max = getMaxLevel(diffs);
        
        // 제한시간 내에 문제를 모두 풀기 위한 숙련도의 최솟값을 구하여라.
        int answer = getLevel(1, max, diffs, times, limit);
        return answer;
    }
    
    // 재귀함수로 범위를 좁히면서 값을 찾을 것
    private int getLevel(int minLevel, int maxLevel, int[] diffs, int[] times, long limit) {
        int answer = maxLevel;

        while (minLevel < maxLevel) {
            int midLevel = (minLevel + maxLevel) / 2;

            if (isClear(midLevel, diffs, times, limit)) {
                answer = midLevel;
                maxLevel = midLevel;
            } else {
                minLevel = midLevel + 1;
            }
        }

        return answer;
    }
    
    private int getMaxLevel(int[] diffs) {
        int max = 0;
        for(int i = 0; i < diffs.length; i++) {
             if(max < diffs[i]) {
                 max = diffs[i];
             }
        }
        return max;
    }
    
    private boolean isClear(int level, int[] diffs, int[] times, long limit) {
        long sum = 0;
        
        // 첫 문제 푸는데 걸리는 시간
        sum += times[0];
        if(diffs[0] > level) {
            sum += (diffs[0] - level) * times[0];
        }
        
        // 문제 순회
        for(int i=1; i<diffs.length; i++) {
            sum += times[i];
            if(diffs[i] > level) {
                sum += (long)(diffs[i] - level) * ((long)times[i] + times[i - 1]);
            }
        }
        return sum <= limit;
    }
}