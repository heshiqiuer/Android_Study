package com.huafu.android_study;

import android.util.Log;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.observable.ObservableObserveOn;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class myTest {

    @Test
    public void testObservable() {

        //第一步，创建被观察者
        Observable<Integer> observable = Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        });

        //第二步，创建观察者
        Observer<Integer> obser = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("onNext = " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        //第三步，通过订阅（subscribe）连接观察者和被观察者
        observable.subscribe(obser);


        System.out.println("====分割线====");

        ///链式写法（常见写法）
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe: " + d);
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("onNext = " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });

    }

    @Test
    public void testJust() {
        Observable.just(1, 2, 3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe: " + d);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext = " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }



    @Test
    public void myTest() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Throwable {
                System.out.println("apply:" + integer);
                return "map函数处理后"+integer+"变成了字符串类型";
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe:" + d);
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("onNext:" + s);

            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + e);

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });




    }

}

