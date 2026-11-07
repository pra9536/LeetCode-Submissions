class MyCalendarTwo {

    List<int[]> bookings;
    List<int[]> overlappings;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlappings = new ArrayList<>();
    }
    
    public boolean overlap(int []el, int s2, int e2) {
        int s1 = el[0];
        int e1 = el[1];

        return e1 >= s2 && e2 >= s1;
    }

    public boolean book(int startTime, int endTime) {
        if(bookings.size() == 0) {
            bookings.add(new int[]{
                startTime,
                endTime - 1
            });
            return true;
        }

        // check overlap
        for(int i = 0; i<overlappings.size(); i++){
            if(overlap(overlappings.get(i), startTime, endTime-1)) return false;
        }

        // if no overlap then insert into the overlapping list


        for(int i = 0; i<bookings.size(); i++) {
            if(overlap(bookings.get(i), startTime, endTime-1)) {

                overlappings.add(new int[]{
                   Math.max(bookings.get(i)[0], startTime),
                   Math.min(bookings.get(i)[1], endTime-1)
                });

            }
        }

        bookings.add(new int[] {
            startTime,
            endTime - 1
        });
        return true;



    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */