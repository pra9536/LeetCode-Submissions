class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int left = 0;
        int right = 0;

        int count = 0;

        while(left < players.length && right < trainers.length) {
            if(players[left] > trainers[right]) right++;

            else {
                count++;
                right++;
                left++;
            }
        }

        return count;
    }
}