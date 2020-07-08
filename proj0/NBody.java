public class NBody {
    public static double readRadius(String txt) {
        In in = new In(txt);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

    /* the hardest test */
    public static Planet[] readPlanets(String txt) {
        In in = new In(txt);
        int N = in.readInt();
        double R = in.readDouble();
        Planet[] allPlanets;
        allPlanets = new Planet[5];
        for (int i = 0;i < allPlanets.length; i+=1){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            allPlanets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return allPlanets;
    }

    public static void main(String args[]){

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double R = readRadius(filename);
        Planet[] allPlanets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-R, R);
        StdDraw.setYscale(-R, R);
        StdAudio.play("audio/2001.mid");
        for (double T0 = 0; T0 < T; T0 += dt){
            double[] xForces = new double[5];
            double[] yForces = new double[5];
            for (int i = 0;i < allPlanets.length; i += 1){
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
            }
            for (int i = 0;i < allPlanets.length; i += 1){
                allPlanets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0.5,0.5,"images/starfield.jpg");
            for(Planet planet: allPlanets){
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i< allPlanets.length; i +=1 ){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                            allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                            allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
        }
    }
}
