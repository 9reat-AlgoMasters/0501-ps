import java.util.*;

class Solution {

    static class Time implements Comparable<Time> {
        int hour, min;

        public Time(String time) {
            String[] info = time.split(":");
            hour = Integer.parseInt(info[0]);
            min = Integer.parseInt(info[1]);
        }

        public int diff(Time o) {
            int thisTime = this.hour*60 + this.min;
            int oTime = o.hour*60 + o.min;
            return oTime - thisTime;
        }

        @Override
        public boolean equals(Object other) {
            Time o = (Time) other;
            return this.hour == o.hour && this.min == o.min;
        }

        @Override
        public int compareTo(Time o) {
            return this.hour == o.hour ? this.min - o.min : this.hour - o.hour;
        }

        @Override
        public String toString() {
            return hour + "시 " + min + "분";
        }
    }

    static class Meeting implements Comparable<Meeting> {
        Time start, end;

        public Meeting(Time start, Time end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            return o.end.equals(this.end) ? this.start.compareTo(o.start) : this.end.compareTo(o.end);
        }

        @Override
        public String toString() {
            return "시작 : " + start + "\n끝 : " + end;
        }
    }

    static int N;
    static Meeting[] meetings;

    public int solution(String[][] book_time) {
        N = book_time.length;
        meetings = new Meeting[N];
        for (int i=0; i<N; i++) {
            meetings[i] = new Meeting(new Time(book_time[i][0]), new Time(book_time[i][1]));
        }

        Arrays.sort(meetings);

        List<Time> distributed = new ArrayList<>();
        distributed.add(meetings[0].end);

        for (int i=1; i<N; i++) {
            int len = distributed.size();
            int idx = -1;
            int minDiff = Integer.MAX_VALUE;

            for (int j=0; j<len; j++) {
                int startDiff = distributed.get(j).diff(meetings[i].start);

                if (startDiff < 10) {
                    continue;
                }


                if (startDiff < minDiff) {
                    idx = j;
                    minDiff = startDiff;
                }
            }

            if (idx == -1) {
                distributed.add(meetings[i].end);
            } else {
                distributed.set(idx, meetings[i].end);
            }
        }

        return distributed.size();
    }
}