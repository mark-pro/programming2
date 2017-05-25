class Sphere {
    private double sphereVolume;
    public Sphere(int radius) {
        this.sphereVolume = 
            (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    }

    public double getSphereVoluem() {
        return this.sphereVolume;
    }    
    public void setSphereVolume(double sphereVolume) {
        this.sphereVolume = sphereVolume;
    }
}