  .data
  .align  2
  .globl  class_nameTab
  .globl  Main_protObj
  .globl  Int_protObj
  .globl  String_protObj
  .globl  bool_const0
  .globl  bool_const1
  .globl  _int_tag
  .globl  _bool_tag
  .globl  _string_tag
_int_tag:
  .word   2
_bool_tag:
  .word   3
_string_tag:
  .word   4
  .globl  _MemMgr_TEST
_MemMgr_TEST:
  .word   0
str_const15:
  .word   4
  .word   5
  .word   String_dispTab
  .word   int_const0
  .byte  0
  .align  2
str_const14:
  .word   4
  .word   6
  .word   String_dispTab
  .word   int_const1
  .ascii  "Main"
  .byte  0
  .align  2
str_const13:
  .word   4
  .word   6
  .word   String_dispTab
  .word   int_const2
  .ascii  "String"
  .byte  0
  .align  2
str_const12:
  .word   4
  .word   6
  .word   String_dispTab
  .word   int_const1
  .ascii  "Bool"
  .byte  0
  .align  2
str_const11:
  .word   4
  .word   5
  .word   String_dispTab
  .word   int_const3
  .ascii  "Int"
  .byte  0
  .align  2
str_const10:
  .word   4
  .word   5
  .word   String_dispTab
  .word   int_const4
  .ascii  "IO"
  .byte  0
  .align  2
str_const9:
  .word   4
  .word   6
  .word   String_dispTab
  .word   int_const2
  .ascii  "Object"
  .byte  0
  .align  2
str_const8:
  .word   4
  .word   7
  .word   String_dispTab
  .word   int_const5
  .ascii  "_prim_slot"
  .byte  0
  .align  2
str_const7:
  .word   4
  .word   7
  .word   String_dispTab
  .word   int_const6
  .ascii  "SELF_TYPE"
  .byte  0
  .align  2
str_const6:
  .word   4
  .word   7
  .word   String_dispTab
  .word   int_const6
  .ascii  "_no_class"
  .byte  0
  .align  2
str_const5:
  .word   4
  .word   8
  .word   String_dispTab
  .word   int_const7
  .ascii  "<basic class>"
  .byte  0
  .align  2
str_const4:
  .word   4
  .word   7
  .word   String_dispTab
  .word   int_const8
  .ascii  "not void"
  .byte  0
  .align  2
str_const3:
  .word   4
  .word   6
  .word   String_dispTab
  .word   int_const1
  .ascii  "void"
  .byte  0
  .align  2
str_const2:
  .word   4
  .word   6
  .word   String_dispTab
  .word   int_const9
  .ascii  "false"
  .byte  0
  .align  2
str_const1:
  .word   4
  .word   6
  .word   String_dispTab
  .word   int_const1
  .ascii  "true"
  .byte  0
  .align  2
str_const0:
  .word   4
  .word   6
  .word   String_dispTab
  .word   int_const10
  .ascii  "good.cl"
  .byte  0
  .align  2
int_const10:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   7
int_const9:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   5
int_const8:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   8
int_const7:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   13
int_const6:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   9
int_const5:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   10
int_const4:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   2
int_const3:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   3
int_const2:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   6
int_const1:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   4
int_const0:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   0
bool_const0:
  .word   3
  .word   4
  .word   Bool_dispTab
  .word   0
bool_const1:
  .word   3
  .word   4
  .word   Bool_dispTab
  .word   1
class_nameTab:
  .word   str_const5
  .word   str_const6
  .word   str_const7
  .word   str_const8
  .word   str_const9
  .word   str_const10
class_objTab:
  .word   Object_protObj
  .word   Object_init
  .word   IO_protObj
  .word   IO_init
  .word   Int_protObj
  .word   Int_init
  .word   Bool_protObj
  .word   Bool_init
  .word   String_protObj
  .word   String_init
  .word   Main_protObj
  .word   Main_init
Object_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
IO_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   IO.out_string
  .word   IO.out_int
  .word   IO.in_string
  .word   IO.in_int
Main_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   IO.out_string
  .word   IO.out_int
  .word   IO.in_string
  .word   IO.in_int
  .word   Main.main
Int_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
Bool_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
String_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   String.length
  .word   String.concat
  .word   String.substr
Object_protObj:
  .word   0
  .word   3
  .word   Object_dispTab
IO_protObj:
  .word   1
  .word   3
  .word   IO_dispTab
Int_protObj:
  .word   2
  .word   4
  .word   Int_dispTab
  .word   0
Bool_protObj:
  .word   3
  .word   4
  .word   Bool_dispTab
  .word   0
String_protObj:
  .word   4
  .word   5
  .word   String_dispTab
  .word   int_const0
  .word   0
Main_protObj:
  .word   5
  .word   7
  .word   Main_dispTab
  .word   int_const0
  .word   str_const15
  .word   bool_const0
  .word   0
  .globl  heap_start
heap_start:
  .word   0
  .text
  .globl  Main_init
  .globl  Int_init
  .globl  String_init
  .globl  Bool_init
  .globl  Main.main
Object_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
IO_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Object_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
Main_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   IO_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
Int_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Object_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
Bool_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Object_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
String_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Object_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
Main.main:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  lw    a0 0(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label0
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label0:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 0(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label1
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label1:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  lw    a0 0(a0)
  lw    t1 12(a0)
  beqz  t1 label3
  la    a0 str_const1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label4
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label4:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  j     label2
label3:
  la    a0 str_const2
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label5
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label5:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
label2:
  lw    a0 0(a0)
  mv    t1 a0
  la    a0 bool_const0
  beq   s0 t1 label8
  la    a0 bool_const1
label8:
  lw    t1 12(a0)
  beqz  t1 label7
  la    a0 str_const3
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label9
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label9:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  j     label6
label7:
  la    a0 str_const4
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label10
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label10:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
label6:
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
asdfasdasd
asdfasdasd
asdfasdasd
asdfasdasd
asdfasdfasdfasdfasdf
