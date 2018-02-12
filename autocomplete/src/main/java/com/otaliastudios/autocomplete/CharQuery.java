package com.otaliastudios.autocomplete;

public class CharQuery implements Query {
    private CharSequence charSequence;

    public CharQuery() {
    }

    @Override
    public CharSequence getCharSequence() {
        return charSequence;
    }


    public void setCharSequence(CharSequence charSequence) {
        this.charSequence = charSequence;
    }
}
