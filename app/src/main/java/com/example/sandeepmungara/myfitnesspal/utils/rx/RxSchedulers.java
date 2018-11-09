package com.example.sandeepmungara.myfitnesspal.utils.rx;

import rx.Scheduler;

public interface RxSchedulers {

    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();
}
