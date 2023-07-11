public class NBody
{
    public static double readRadius(String filename)
    {
        In in = new In(filename);
        int num = in.readInt();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String filename)
    {
        In in = new In(filename);
        int arraySize= in.readInt();
        Planet[] planets = new Planet[arraySize];
        double rub = in.readDouble();
        for(int i=0 ; i < arraySize ; i++)
        {
            planets[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return planets;
    }
    public static void main(String[] args)
    {
        double T = Double.parseDouble(args[0]), dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for(int i=0;i<planets.length;i++)
        {
            planets[i].draw();
        }
        StdDraw.enableDoubleBuffering();
        int arraySize = planets.length;
        double timestamp=0;
        while(timestamp<T)
        {
            double[] xForces=new double[arraySize];
            double[] yForces=new double[arraySize];
            for(int i=0;i<arraySize;i++)
            {
                xForces[i]=planets[i].calcNetForceExertedByX(planets);
                yForces[i]=planets[i].calcNetForceExertedByX(planets);
            }
            for(int i=0;i<arraySize;i++)
            {
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for(int i=0;i<arraySize;i++)
            {
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            timestamp+=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++)
        {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}