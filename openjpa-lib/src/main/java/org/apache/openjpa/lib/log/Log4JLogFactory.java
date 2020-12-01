/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.lib.log;


import org.apache.openjpa.lib.util.ClassUtil;

/**
 * {@link LogFactory} implementation that delegates to the Log4J framework.
 *
 * This class will automatically detect which version of log4j is available and adopt to it.
 *
 * @author Patrick Linskey
 */
public class Log4JLogFactory extends LogFactoryAdapter {

    @Override
    protected Log newLogAdapter(String channel) {
        if (ClassUtil.classExists("org.apache.logging.log4j.LogManager", this.getClass().getClassLoader())) {
            return new Log4J2Adapter(channel);
        }
        else {
            return new Log4J1Adapter(channel);
        }
    }

    /**
     * Adapts a Log4J-2.x logger to the {@link org.apache.openjpa.lib.log.Log}
     * interface.
     */
    public static class Log4J2Adapter implements Log {

        private org.apache.logging.log4j.Logger _log;

        private Log4J2Adapter(String channel) {
            _log = org.apache.logging.log4j.LogManager.getLogger(channel);
        }

        public org.apache.logging.log4j.Logger getDelegate() {
            return _log;
        }

        @Override
        public boolean isTraceEnabled() {
            return _log.isTraceEnabled();
        }

        @Override
        public boolean isInfoEnabled() {
            return _log.isInfoEnabled();
        }

        @Override
        public boolean isWarnEnabled() {
            return _log.isWarnEnabled();
        }

        @Override
        public boolean isErrorEnabled() {
            return _log.isErrorEnabled();
        }

        @Override
        public boolean isFatalEnabled() {
            return _log.isFatalEnabled();
        }

        @Override
        public void trace(Object o) {
            _log.debug(o);
        }

        @Override
        public void trace(Object o, Throwable t) {
            _log.debug(o, t);
        }

        @Override
        public void info(Object o) {
            _log.info(o);
        }

        @Override
        public void info(Object o, Throwable t) {
            _log.info(o, t);
        }

        @Override
        public void warn(Object o) {
            _log.warn(o);
        }

        @Override
        public void warn(Object o, Throwable t) {
            _log.warn(o, t);
        }

        @Override
        public void error(Object o) {
            _log.error(o);
        }

        @Override
        public void error(Object o, Throwable t) {
            _log.error(o, t);
        }

        @Override
        public void fatal(Object o) {
            _log.fatal(o);
        }

        @Override
        public void fatal(Object o, Throwable t) {
            _log.fatal(o, t);
        }
    }



    /**
     * Adapts a Log4J-1.x logger to the {@link org.apache.openjpa.lib.log.Log}
     * interface.
     */
    public static class Log4J1Adapter implements Log {

        private org.apache.log4j.Logger _log;

        private Log4J1Adapter(String channel) {
            _log = org.apache.log4j.LogManager.getLogger(channel);
        }

        public org.apache.log4j.Logger getDelegate() {
            return _log;
        }

        @Override
        public boolean isTraceEnabled() {
            return _log.isEnabledFor(org.apache.log4j.Level.DEBUG);
        }

        @Override
        public boolean isInfoEnabled() {
            return _log.isEnabledFor(org.apache.log4j.Level.INFO);
        }

        @Override
        public boolean isWarnEnabled() {
            return _log.isEnabledFor(org.apache.log4j.Level.WARN);
        }

        @Override
        public boolean isErrorEnabled() {
            return _log.isEnabledFor(org.apache.log4j.Level.ERROR);
        }

        @Override
        public boolean isFatalEnabled() {
            return _log.isEnabledFor(org.apache.log4j.Level.FATAL);
        }

        @Override
        public void trace(Object o) {
            _log.debug(o);
        }

        @Override
        public void trace(Object o, Throwable t) {
            _log.debug(o, t);
        }

        @Override
        public void info(Object o) {
            _log.info(o);
        }

        @Override
        public void info(Object o, Throwable t) {
            _log.info(o, t);
        }

        @Override
        public void warn(Object o) {
            _log.warn(o);
        }

        @Override
        public void warn(Object o, Throwable t) {
            _log.warn(o, t);
        }

        @Override
        public void error(Object o) {
            _log.error(o);
        }

        @Override
        public void error(Object o, Throwable t) {
            _log.error(o, t);
        }

        @Override
        public void fatal(Object o) {
            _log.fatal(o);
        }

        @Override
        public void fatal(Object o, Throwable t) {
            _log.fatal(o, t);
        }
    }
}
