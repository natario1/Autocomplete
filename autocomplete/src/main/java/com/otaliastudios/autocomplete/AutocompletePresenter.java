package com.otaliastudios.autocomplete;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

/**
 * Base class for presenting items inside a popup. This is abstract and must be implemented.
 *
 * Most important methods are {@link #getView()} and {@link #onQuery(CharSequence)}.
 */
public abstract class AutocompletePresenter<T> {

    private Context context;
    private boolean isShowing;

    public AutocompletePresenter(Context context) {
        this.context = context;
    }

    /**
     * At this point the presenter is passed the {@link ClickProvider}.
     * The contract is that {@link ClickProvider#click(Object)} must be called when a list item
     * is clicked. This ensure that the autocomplete callback will receive the event.
     *
     * @param provider a click provider for this presenter.
     */
    protected void onStart(ClickProvider<T> provider) {

    }

    /**
     * Called each time the popup is shown. You are meant to inflate the view here.
     * You can get a LayoutInflater using {@link #getContext()}.
     *
     * @return a ViewGroup for the popup
     */
    protected abstract ViewGroup getView();

    /**
     * Provide the {@link PopupDimensions} for this popup. Called just once.
     * You can use fixed dimensions or {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} and
     * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}.
     *
     * @return a PopupDimensions object
     */
    // Called at first to understand which dimensions to use for the popup.
    protected PopupDimensions getPopupDimensions() {
        return new PopupDimensions();
    }

    /**
     * Perform firther initialization here. Called after {@link #getView()},
     * each time the popup is shown.
     */
    protected abstract void onViewShown();

    /**
     * Called to update the view to filter results with the query.
     * It is called any time the popup is shown, and any time the text changes and query is updated.
     *
     * @param query query from the edit text, to filter our results
     */
    protected abstract void onQuery(@Nullable CharSequence query);

    /**
     * Called when the popup is hidden, to release resources.
     */
    protected abstract void onViewHidden();

    /**
     * @return this presenter context
     */
    protected final Context getContext() {
        return context;
    }

    /**
     * @return whether we are showing currently
     */
    protected final boolean isShowing() {
        return isShowing;
    }

    final void showView() {
        isShowing = true;
        onViewShown();
    }

    final void hideView() {
        isShowing = false;
        onViewHidden();
    }

    interface ClickProvider<T> {
        void click(T item);
    }

    /**
     * Useful if you wish to change width/height based on content height.
     * The contract is to call {@link DataSetObserver#onChanged()} when your view has
     * changes.
     *
     * This is called after {@link #getView()}.
     *
     * @param observer the observer.
     */
    protected void registerDataSetObserver(DataSetObserver observer) {}

    /**
     * Provides width, height, maxWidth and maxHeight for the popup.
     * @see #getPopupDimensions()
     */
    public static class PopupDimensions {
        public int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        public int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        public int maxWidth = Integer.MAX_VALUE;
        public int maxHeight = Integer.MAX_VALUE;
    }
}
