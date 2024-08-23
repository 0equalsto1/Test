package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MeetingRoom {

	public static void main(String[] args) {
		int start[] = { 1, 2, 0, 5, 8, 5 };
		int end[] = { 3, 3, 6, 7, 9, 9 };
		maxMeetings(start, end);
	}

		public int[][] mergeIntervals(int[][] intervals) {
	        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
	        LinkedList<int[]> merged = new LinkedList<>();
	        for (int[] interval : intervals) {
	            // if the list of merged intervals is empty or if the current
	            // interval does not overlap with the previous, simply append it.
	            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
	                merged.add(interval);
	            }
	            // otherwise, there is overlap, so we merge the current and previous
	            // intervals.
	            else {
	                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
	            }
	        }
	        return merged.toArray(new int[merged.size()][]);
	    }


	static List<Meeting> maxMeetings(int start[], int end[]) {
		List<Meeting> meetings = new ArrayList<>();

		for (int i = 0; i < start.length; i++)
			meetings.add(new Meeting(start[i], end[i], i + 1));

		MeetingComparator mc = new MeetingComparator();
		Collections.sort(meetings, mc);
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(meetings.get(0).pos);
		int endTime = meetings.get(0).end;

		for (int i = 1; i < start.length; i++) {
			if (meetings.get(i).start > endTime) {
				endTime = meetings.get(i).end;
				answer.add(meetings.get(i).pos);
			}
		}

		return meetings;
	}
}

class Meeting {
	int start;
	int end;
	int pos;

	Meeting(int start, int end, int pos) {
		this.start = start;
		this.end = end;
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "(start=" + start + ", end=" + end + ", pos=" + pos + ")";
	}

}

class MeetingComparator implements Comparator<Meeting> {
	@Override
	public int compare(Meeting o1, Meeting o2) {
		if (o1.end < o2.end)
			return -1;
		else if (o1.end > o2.end)
			return 1;
		else if (o1.pos < o2.pos)
			return -1;
		return 1;
	}
}
