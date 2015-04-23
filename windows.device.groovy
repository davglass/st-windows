//Thing is used while a device is in the process of being joined

metadata {
    // Automatically generated. Make future change here.
    definition (name: "Windows", namespace: "davglass", author: "Dav Glass") {
        capability "Contact Sensor"
        command "count", ["number", "number"]
        
        attribute "value", "string"
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

// Parse incoming device messages to generate events
def parse(String description) {
    // None
}


def count(open, closed) {
    def status = ((open == 0) ? "closed" : "open");
    log.debug "Open: ${open}, Closed: ${closed}, Status: ${status}"
    sendEvent(name: "contact", value: status)
    sendEvent(name: "value", value: "${open}/${closed}")
}

