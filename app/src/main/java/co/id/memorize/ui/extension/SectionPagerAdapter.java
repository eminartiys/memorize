package co.id.memorize.ui.extension;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import co.id.memorize.ui.film.FilmFeedFragment;

/**
 * Created by eminartiys on 17/02/18.
 */

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new FilmFeedFragment();
//            case 1:
//                return new Fragment2();
//                break;
//            case 2:
//                return new Fragment3();
//                break;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "Film";
            case 1:
                return "Fragment 2 title";
            case 2:
                return "Fragment 3 title";
            default:
                return "";
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 1;
    }
}