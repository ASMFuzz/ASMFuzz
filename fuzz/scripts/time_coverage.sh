#!/bin/bash

# Parameter 1: Log file name.
# Parameter 2: NUM, a parameter of string type.
LOG_FILE="$1"
NUM="$2"
INDEX="$3"

# Log function
function log() {
    # Use the 'date' command to get the current time, add 8 hours, and output the format as yyyy-mm-dd HH:MM:SS.
    local timestamp=$(date -d "+8 hour" "+%Y-%m-%d %H:%M:%S")
    # Output the log information to a file.
    echo "$timestamp - $@" >> "$LOG_FILE"
}

# Record the start time of the script execution.
log "Script execution started."

# Execute the first command.
lcov_cmd="lcov -d /root/jvm/openjdk11/jdk-11.0.14-ga/build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs --rc lcov_branch_coverage=1 --gcov-tool /usr/bin/gcov -c -o /root/shannonfuzz-python/fuzz/coverage/mm${NUM}/output${NUM}group${INDEX}.info"
log "Execute command: $lcov_cmd"
eval "$lcov_cmd"
log "Command execution complete."

# Execute the second command.
genhtml_cmd="genhtml --rc genhtml_branch_coverage=1 -o /root/shannonfuzz-python/fuzz/coverage/mm${NUM}/HtmlFile${INDEX} /root/shannonfuzz-python/fuzz/coverage/mm${NUM}/output${NUM}group${INDEX}.info >> /root/shannonfuzz-python/fuzz/coverage/mm${NUM}/all${INDEX}.txt"
log "Execute command: $genhtml_cmd"
eval "$genhtml_cmd"
log "Command execution complete."

# Execute the third command.
lcov_cmd="lcov -d /root/jvm/openjdk11/jdk-11.0.14-ga -z"
log "Execute command:$lcov_cmd"
eval "$lcov_cmd"
log "Command execution complete."

# Record the end time of the script execution.
log "Script execution finished."
