import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import java.util.HashSet;


public class PercolationStats {
    private int n;
    private int trials;
    private double[] results;



    public PercolationStats(int n, int trials) {
        if (trials <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.trials = trials;

        this.results = new double[trials];
        for (int i = 0; i < this.trials; i++) {

            Percolation percolation = new Percolation(n);
            HashSet<Integer> usedCells = new HashSet<>();
            while (!percolation.percolates()) {

                int randomRow = StdRandom.uniform(this.n)+1;
                int randomCol = StdRandom.uniform(this.n)+1;

                if (!usedCells.contains(n*(randomRow-1)+randomCol-1) ) {
                    percolation.open(randomRow, randomCol);
                    PercolationVisualizer.draw(percolation, n);
                    usedCells.add(n*(randomRow-1)+randomCol-1);


                }


            }
            results[i] = percolation.numberOfOpenSites()*1.0/(n*n);
        }
    }

    public double mean() {
        return StdStats.mean(results);
    }

    public double stddev() {
        return StdStats.stddev(results);
    }

    public double confidenceLo() {
        return mean()-1.96*(stddev()/Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean()+1.96*(stddev()/Math.sqrt(trials));
    }

    public static void main(String[] args) {
        int n;
        int trials;
        if (args == null) {
            throw new IllegalArgumentException();
        }
        else {
            n = Integer.parseInt(args[0]);
            trials = Integer.parseInt(args[1]);
            if (trials <= 0) {
                throw new IllegalArgumentException();
            }


        }
        PercolationStats percolationStats = new PercolationStats(n, trials);
        System.out.println(percolationStats.mean());




    }
}
