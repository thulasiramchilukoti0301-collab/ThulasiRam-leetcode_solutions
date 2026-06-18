class Solution {
    public double angleClock(int hour, int minutes) {
        double HourAngle = 30 * (hour % 12) + 0.5 * minutes;
        double MinutesAngle =  6 * minutes;
        double Angle = Math.abs(HourAngle - MinutesAngle);
        return Math.min(Angle, 360 - Angle);
    }
}