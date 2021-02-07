package co.com.ceiba.mobile.pruebadeingreso.view;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.com.ceiba.mobile.pruebadeingreso.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AppTestIU {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void appTestIU() {

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextSearch),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextSearch),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("gra"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_view_post), withText("Ver publicaciones"),
                        childAtPosition(
                                allOf(withId(R.id.contentBtnViewPost),
                                        childAtPosition(
                                                withId(R.id.contentCard),
                                                3)),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        pressBack();

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editTextSearch), withText("gra"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editTextSearch), withText("gra"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("menti"));

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editTextSearch), withText("menti"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_view_post), withText("Ver publicaciones"),
                        childAtPosition(
                                allOf(withId(R.id.contentBtnViewPost),
                                        childAtPosition(
                                                withId(R.id.contentCard),
                                                3)),
                                0),
                        isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editTextSearch), withText("menti"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText6.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editTextSearch), withText("menti"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("hOwEl"));

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.editTextSearch), withText("hOwEl"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText8.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn_view_post), withText("Ver publicaciones"),
                        childAtPosition(
                                allOf(withId(R.id.contentBtnViewPost),
                                        childAtPosition(
                                                withId(R.id.contentCard),
                                                3)),
                                0),
                        isDisplayed()));
        appCompatButton3.perform(click());

        pressBack();

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.editTextSearch), withText("hOwEl"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText9.perform(click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.editTextSearch), withText("hOwEl"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText10.perform(replaceText("12356"));

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.editTextSearch), withText("12356"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText11.perform(closeSoftKeyboard());

        ViewInteraction textView = onView(
                allOf(withText("List is empty"),
                        withParent(withParent(withId(R.id.content))),
                        isDisplayed()));
        textView.check(matches(withText("List is empty")));

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.editTextSearch), withText("12356"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("qwerty"));

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.editTextSearch), withText("qwerty"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText13.perform(closeSoftKeyboard());

        ViewInteraction textView2 = onView(
                allOf(withText("List is empty"),
                        withParent(withParent(withId(R.id.content))),
                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.editTextSearch), withText("qwerty"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText14.perform(replaceText(""));

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.editTextSearch),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textInputLayoutSearch),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText15.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btn_view_post), withText("Ver publicaciones"),
                        childAtPosition(
                                allOf(withId(R.id.contentBtnViewPost),
                                        childAtPosition(
                                                withId(R.id.contentCard),
                                                3)),
                                0),
                        isDisplayed()));
        appCompatButton4.perform(click());

        pressBack();
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
