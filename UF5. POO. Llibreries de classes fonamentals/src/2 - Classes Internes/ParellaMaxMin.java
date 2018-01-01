public class ParellaMaxMin {

    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Parella p = ArrayAlg.minmax(d);
        System.out.println("min = " + p.getPrimer());
        System.out.println("max = " + p.getSegon());
    }
}

class ArrayAlg {

    public static class Parella {

        private double primer;
        private double segon;

        public Parella(double f, double s) {
            primer = f;
            segon = s;
        }

        public double getPrimer() {
            return primer;
        }

        public double getSegon() {
            return segon;
        }
    }

    public static Parella minmax(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double v : values) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
        }
        return new Parella(min, max);
    }
}