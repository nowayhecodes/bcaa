package com.nowayhecodes.PoorActor.core;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import org.immutables.value.Value;

@Value.Immutable
public interface CacheCreated {
    Path getFilePath();
    Long getTtl();
    TimeUnit getTimeUnit();
}

@Value.Immutable
public interface CacheExpired {
    Path getFilePath();
}