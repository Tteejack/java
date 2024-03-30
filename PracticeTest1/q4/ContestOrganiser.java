public class ContestOrganiser {
    public static final int NUM_ROWS=10;
    public static final int CONTESTANT_PER_ROWS=11;
    private Contestant[][] contestants;

    public ContestOrganiser( ) {
        this.contestants =
                new Contestant[NUM_ROWS][CONTESTANT_PER_ROWS];
        for(int i=0; i<NUM_ROWS; i++) {
            for(int c=0; c<CONTESTANT_PER_ROWS; c++) {
                contestants[i][c] = new Contestant("name"+i+"_"+c,
                        (int)(Math.random()*50000) );
            }
        }
    }

    public void sort(Contestant[] arr) {
        for(int i=0; i<arr.length-1; i++) { // -1?
            int minIdx = i;
            for(int j=i+1; j<arr.length; j++) {
                if (arr[j].getScore() < arr[minIdx].getScore()) {
                    minIdx = j;
                }
            }
            Contestant tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }

    public void sortAllRows() {
        for(Contestant[] row:contestants ) {
            sort(row);
        }
    }

    public String findWinnerName() {
        sortAllRows();
        Contestant winner = contestants[0][CONTESTANT_PER_ROWS-1];

        for(Contestant[] r:contestants) {
            Contestant newWinner = r[r.length-1];
            if( newWinner.getScore() > winner.getScore()) {
                winner = newWinner;
            }
        }
        return winner.getName();
    }
}
