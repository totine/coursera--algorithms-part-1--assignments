/**
 * Created by joanna on 24.04.17.
 */
public class roboczy {
    public static void main(String[] args) {
        Percolation perc = new Percolation(6);
        int[] a = {1,2,3,4,5,5,4,3,2,2,2,2,3,4,5,5,6,5};

        int[] b = {6,6,6,6,6,5,4,4,4,3,2,1,1,1,1,2,2,4};
        for (int i=0;i<a.length;i++) {
            System.out.println(a[i]+" "+b[i]);
            perc.open(a[i], b[i]);
            ;
            PercolationVisualizer.draw(perc,6);
            System.out.println("Percolated"+perc.percolates());
            System.out.println(a[i]+" "+b[i]+"is_open"+perc.isOpen(a[i], b[i]));
            System.out.println(a[i]+" "+b[i]+"is_full"+perc.isFull(a[i], b[i]));
        }
    }
}
