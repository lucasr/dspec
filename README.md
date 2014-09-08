DSpec
=====

An easy way to draw UI specs on top of your Android UI.

![](images/sample.png)



Usage
-----

Enclose the target UI with a `DesignSpecFrameLayout`, usually the root of your view hierarchy.
Get the associated `DesignSpec` instance with `getDesignSpec` and then you can: 

 * Toggle baseline grid visibility with `setBaselineGridVisible(boolean)`.
 * Change baseline grid cell width with `setBaselineGridCellSize(int)`.
 * Change baseline grid color with `setBaselineGridColor(int)`.
 * Toggle keylines visibility with `setKeylinesVisible(boolean)`.
 * Change keylines color with `setKeylinesColor(int)`.
 * Add keylines with `addKeyline(int, From)`.
 * Toggle spacings visibility with `setSpacingsVisible(boolean)`.
 * Change spacings color with `setSpacingsColor(int)`.
 * Add spacing with `addSpacing(int, int, From)`.

You can also specify the design spec in a raw JSON resource like:

```json
{
    "baselineGridVisible": true,
    "baselineGridCellSize": 8,
    "keylines": [
        { "offset": 16,
          "from": LEFT },
        { "offset": 72,
          "from": LEFT },
        { "offset": 16,
          "from": RIGHT }
    ],
    "spacings": [
        { "offset": 0,
          "size": 16,
          "from": LEFT },
        { "offset": 56,
          "size": 16,
          "from": LEFT },
        { "offset": 0,
          "size": 16,
          "from": RIGHT }
    ]
}
```


Download
--------

Download [the latest JAR][1] or grab via Gradle:
```groovy
compile 'org.lucasr.dspec:dspec:0.1.0'
```
or Maven:
```xml
<dependency>
  <groupId>org.lucasr.dspec</groupId>
  <artifactId>dspec</artifactId>
  <version>0.1.0</version>
</dependency>
```



License
--------

    Copyright 2014 Lucas Rocha

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [1]: http://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=org.lucasr.dspec&a=dspec&v=LATEST
