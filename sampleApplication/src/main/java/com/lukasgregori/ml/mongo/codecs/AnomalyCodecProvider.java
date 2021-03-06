/*********************************************************************
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Lukas Gregori
 * contact@lukasgregori.com
 * www.lukasgregori.com
 *
 * (c) 2018 by Lukas Gregori
 *********************************************************************/

package com.lukasgregori.ml.mongo.codecs;

import com.lukasgregori.ml.anomaly.detection.util.LoggingAnomaly;
import com.lukasgregori.ml.clustering.impl.sostream.SOCluster;
import com.lukasgregori.ml.input.util.CustomLoggingEvent;
import com.lukasgregori.ml.mongo.codecs.impl.CustomLoggingEventCodec;
import com.lukasgregori.ml.mongo.codecs.impl.LoggingAnomalyCodec;
import com.lukasgregori.ml.mongo.codecs.impl.SOClusterCodec;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

/**
 * @author Lukas Gregori
 */
public class AnomalyCodecProvider implements CodecProvider {

    @Override
    @SuppressWarnings("unchecked")
    public <T> Codec<T> get(Class<T> itemClass, CodecRegistry codecRegistry) {
        if (itemClass == LoggingAnomaly.class) {
            return (Codec<T>) new LoggingAnomalyCodec(codecRegistry);
        } else if (itemClass == SOCluster.class) {
            return (Codec<T>) new SOClusterCodec(codecRegistry);
        } else if (itemClass == CustomLoggingEvent.class) {
            return (Codec<T>) new CustomLoggingEventCodec(codecRegistry);
        }
        return null;
    }
}
