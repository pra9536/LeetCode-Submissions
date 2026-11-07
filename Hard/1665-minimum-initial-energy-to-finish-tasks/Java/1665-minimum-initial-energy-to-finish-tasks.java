class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> Integer.compare((b[1] - b[0]), (a[1] - a[0])));

        int count = 0;
        int energy = 0;

        for(int i = 0; i<tasks.length; i++){


            int actual = tasks[i][0];
            int minimum = tasks[i][1];

            if(energy < minimum){
                count += (minimum - energy);
                energy = minimum;
            }

            energy -= actual;
        }
        return count;


    }
}