public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G=6.67e-11;
	public Planet(double xP, double yP, double xV, double yV, double m, String img)
	{
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}
	public Planet(Planet p)
	{
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;
	}
	/**
	 *  calculate distance between tow planets;
	 */
	public double calcDistance(Planet p)
	{
		return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));
	}
	/**
	 *  calculate force exerted by another planet;
	 */
	public double calcForceExertedBy(Planet p)
	{
		return G*mass*p.mass/((this.calcDistance(p))*(this.calcDistance(p)));
	}
	public double calcForceExertedByX(Planet p)
	{
		return this.calcForceExertedBy(p)*(p.xxPos-xxPos)/this.calcDistance(p);
	}
	public double calcForceExertedByY(Planet p)
	{
		return this.calcForceExertedBy(p)*(p.yyPos-yyPos)/this.calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] planets) 
	{
        double netForceX = 0.0;

        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                double forceX = this.calcForceExertedByX(planet);
                netForceX += forceX;
            }
        }

        return netForceX;
    	}
	public double calcNetForceExertedByY(Planet[] planets) 
	{
        double netForceY = 0.0;

        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                double forceY = this.calcForceExertedByY(planet);
                netForceY += forceY;
            }
        }

        return netForceY;
    	}
	public void update(double dt, double fX, double fY)
	{
		xxVel=xxVel+dt*fX/mass;
		yyVel=yyVel+dt*fY/mass;
		xxPos=xxPos+dt*xxVel;
		yyPos=yyPos+dt*yyVel;
	}
	public void draw()
	{
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}
}
