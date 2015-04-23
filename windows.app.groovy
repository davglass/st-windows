/**
 *  Are my Windows Open?
 *
 *  Copyright 2015 Dav Glass
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
definition(
    name: "Are my Windows Open?",
    namespace: "davglass",
    author: "Dav Glass",
    description: "Are my Windows Open?",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
    section("Which Windows?") {
        input "windows", "capability.contactSensor", multiple: true, required: true
    }
    section("Which Thing?") {
        input "thing", "capability.contactSensor", multiple: false, required: true
    }
}

def installed() {
    log.debug "Installed with settings: ${settings}"
    initialize()
}

def updated() {
    log.debug "Updated with settings: ${settings}"
    unsubscribe()
    initialize()
}

def initialize() {
    subscribe(windows, "contact", handler);
    subscribe(app, handler);
}

def handler(evt) {
    log.debug "handler called.."
    def opened = 0;
    windows.each {
        if (it.currentValue("contact") == "open") {
            opened++;
        }
    }
    def closed = windows.size() - opened;
    log.debug "There are ${opened} windows open and ${closed} windows closed.."
    thing.count(opened, closed);
}
