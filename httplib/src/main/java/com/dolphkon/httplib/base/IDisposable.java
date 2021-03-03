package com.dolphkon.httplib.base;

import io.reactivex.disposables.Disposable;

public interface IDisposable {
    void addDisposable(Disposable subscription);
    void unDisposable();
}
