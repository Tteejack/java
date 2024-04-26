public class Show {
    private int[][] seats;
    public static final int NUM_ROWS = 3;
    public static final int SEATS_PER_ROW = 7;

    public Show() {
        seats = new int[NUM_ROWS][SEATS_PER_ROW];
        seats[0][1] = 1;
        seats[0][5] = 1;

        seats[2][5] = 1;
        seats[3][3] = 1;
    }
    public boolean twoTogether() {
        for(int r=0; r < NUM_ROWS; r++) {
            for(int i=0; i<SEATS_PER_ROW; i++) {
                if( seats[r][i] + seats[r][i+1] == 0) {
                    seats[r][i] = 1;
                    seats[r][i+1] = 1;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean twoTogetherEnhacedFor() {
        for(int[] row:seats) {
            for(int i=0; i<SEATS_PER_ROW; i++) {
                if( row[i] + row[i+1] == 0) {
                    row[i] = 1;
                    row[i+1] = 1;
                    return true;
                }
            }
        }
        return false;
    }
    public int findAdjacent(int row, int seatsNeeded) {
        int[] seatsAtRow = seats[row];
        for(int k = 0; k<SEATS_PER_ROW - seatsNeeded; k++) {
            boolean found = true;
            for (int i = 0; i<seatsNeeded; i++) {
                found = seatsAtRow[k+i] == 0;
                if (!found) {
                    break;
                }
            }
            if(found)
                return k;
        }
        return -1;
    }
}
