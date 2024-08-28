@@ -176,7 +176,7 @@
  *    // optionally configure multicast TTL; the TTL defines the scope of a
  *    // multicast datagram, for example, confining it to host local (0) or
  *    // link local (1) etc...
- *    int ttl = ...; // a number betwen 0 and 255
+ *    int ttl = ...; // a number between 0 and 255
  *    sender.setOption(StandardSocketOptions.IP_MULTICAST_TTL, ttl);
  *
  *    // send a packet to a multicast group