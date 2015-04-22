/**
 *  SmartDevice for Windows
 *
 *  Copyright 2015 Dav Glass (davglass@gmail.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */

metadata {
    definition (name: "Windows", namespace: "davglass", author: "Dav Glass") {
        capability "Contact Sensor"
        command "count", ["number"]    
        attribute "value", "number"
    }
    tiles {
        standardTile("contact", "device.contact", width: 1, height: 1) {
            state "open", label: '${name}', icon: "st.Home.home9-icn", backgroundColor: "#ffa81e"
            state "closed", label: '${name}', icon: "st.Home.home9-icn", backgroundColor: "#79b821"
        }
        valueTile("NumberTile", "device.value", decoration: "flat") {
            state "items", label:'${currentValue}'
        }
        main "contact"
        details(["contact", "NumberTile"])
    }
}

def parse(String description) {
}

def count(i) {
    def status = ((i == 0) ? "closed" : "open");
    log.debug "Count: ${i}, Status: ${status}"
    sendEvent(name: "contact", value: status)
    sendEvent(name: "value", value: i)
}
