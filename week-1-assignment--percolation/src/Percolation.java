import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean isDown;
    private boolean isUp;
    private int n;
    private int[] percolationTable;
    private WeightedQuickUnionUF uf;
    private int opened;
    private boolean isPercolated;
    private int maxFull;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.opened = 0;
        this.n = n;
        this.percolationTable = new int[n*n];
        this.uf = new WeightedQuickUnionUF(n*n+2);
        this.isPercolated = false;
        this.maxFull = 0;
        this.isUp = false;
        this.isDown = false;

        }

    public void open(int row, int col) {
        checkInput(row, col);
        if (!isOpen(row, col)) {

            opened++;
            this.percolationTable[n * (row - 1) + col - 1] = 1 ;

            if (row==1)
                uf.union(n * (row - 1) + col - 1, n*n);
            if (row==n)
                uf.union(n * (row - 1) + col - 1, n*n+1);
            if (row < this.n && isOpen(row + 1, col)) {
                this.uf.union(n * (row - 1) + col - 1, n * (row) + col - 1);

            }
            if (col < this.n && isOpen(row, col + 1)) {
                this.uf.union(n * (row - 1) + col - 1, n * (row - 1) + col);

            }
            if (row - 1 > 0 && isOpen(row - 1, col)) {
                this.uf.union(n * (row - 1) + col - 1, n * (row - 2) + col - 1);

            }
            if (col - 1 > 0 && isOpen(row, col - 1)) {
                this.uf.union(n * (row - 1) + col - 1, n * (row - 1) + col - 2);


            }
            if (!uf.connected(n * (row - 1) + col - 1, n*n)) {
                this.percolationTable[n * (row - 1) + col - 1] = -1;
            }

        }
    }



    private void checkInput(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isOpen(int row, int col) {
        checkInput(row, col);
        return this.percolationTable[n*(row-1)+col-1] != 0;
    }


    public boolean isFull(int row, int col) {
        checkInput(row, col);
        return uf.connected(n*(row-1)+col-1, n*n) && this.percolationTable[n*(row-1)+col-1]==1;

    }



    public int numberOfOpenSites() {
        return this.opened;
    }

    public boolean percolates() {
        return uf.connected(n*n, n*n+1);
    }


}