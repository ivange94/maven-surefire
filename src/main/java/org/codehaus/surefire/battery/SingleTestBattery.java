package org.codehaus.surefire.battery;

/*
 * Copyright 2001-2005 The Codehaus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A battery which contains a single test class which is used primarily for running individual tests
 * inside a new JVM instance (fork mode).
 *
 * @author <a href="mailto:jason@maven.org">Jason van Zyl</a>
 * @version $Id:$
 */
public class SingleTestBattery
    extends AbstractBattery
{
    private String testClassName;

    private Class testClass;

    private Object test;

    public SingleTestBattery( String testClassName )
        throws Exception
    {
        this.testClassName = testClassName;

        this.testClass = getClass().getClassLoader().loadClass( testClassName );

        this.test = testClass.newInstance();
    }

    protected Class getTestClass()
    {
        return testClass;
    }

    protected Object getTestClassInstance()
    {
        return test;
    }

    public String getBatteryName()
    {
        return testClass.getName();
    }

}
