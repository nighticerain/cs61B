public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        double r = Math.sqrt(dx * dx + dy * dy);
        return r;
    }

    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        double F = G * mass * p.mass / (r * r);
        return F;
    }

    public double calcForceExertedByX(Planet p){
        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        double dx = p.xxPos - xxPos;
        double Fx = F * dx / r;
        return Fx;
    }

    public double calcForceExertedByY(Planet p){
        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        double dy = p.yyPos - yyPos;
        double Fy = F * dy / r;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double xNetForce = 0.0;
        for(Planet planet: allPlanets ){
            if (this.equals(planet))
                continue;
            xNetForce += calcForceExertedByX(planet);
        }
        return xNetForce;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double yNetForce = 0.0;
        for(Planet planet: allPlanets){
            if (this.equals(planet))
                continue;
            yNetForce += calcForceExertedByY(planet);
        }
        return yNetForce;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}

