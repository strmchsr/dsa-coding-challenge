package com.androidiots.playgriund.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueWithMutex {
    Lock lock = new ReentrantLock();
}
