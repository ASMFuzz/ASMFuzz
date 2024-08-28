@@ -26,12 +26,6 @@
 #ifndef CPU_S390_GLOBALDEFINITIONS_S390_HPP
 #define CPU_S390_GLOBALDEFINITIONS_S390_HPP
 
-// Convenience macro that produces a string literal with the filename
-// and linenumber of the location where the macro was used.
-#ifndef FILE_AND_LINE
-#define FILE_AND_LINE __FILE__ ":" XSTR(__LINE__)
-#endif
-
 #define ShortenBranches true
 
 const int StackAlignmentInBytes = 16;