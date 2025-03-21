class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        // schedules: 출근 희망 시각
        // timelogs: 직원들 출근 시각 2차원 정수 배열
        // startday: 이벤트 시작 요일 정수 (1: 월, 2: 화, ..., 7: 일)
        // answer: 받을 상품의 수
        // 한번도 늦으면 안됨
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int workTime = schedules[i];
            boolean isValid = true;
            workTime += 10;
            if(workTime % 100 >= 60) {
                workTime = workTime + 100 - 60;
            }
            
            for(int j = 0; j < 7; j++) {
                int today = (startday + j) % 7;
                if(today >= 6 || today == 0) {
                    continue;
                }
                if(timelogs[i][j] > workTime) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) answer++;
        }
        
        return answer;
    }
}