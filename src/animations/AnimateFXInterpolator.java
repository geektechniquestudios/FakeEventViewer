package animations;

import javafx.animation.Interpolator;

/** 
 * 
 * Shout out to
 Loïc Sculier aka typhon0
 
 for making the base of this animation code. It's %99 his work
 **/

public final class AnimateFXInterpolator 
{
    private AnimateFXInterpolator() 
    {
        throw new IllegalStateException("AnimateFX Interpolator");
    }

    public static final Interpolator EASE = Interpolator.SPLINE(0.25, 0.1, 0.25, 1);
}