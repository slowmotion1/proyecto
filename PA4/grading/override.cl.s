# start of generated code
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
  .word   3
_bool_tag:
  .word   4
_string_tag:
  .word   5
  .globl  _MemMgr_TEST
_MemMgr_TEST:
  .word   0
str_const16:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const6
  .byte  0
  .align  2
str_const15:
  .word   5
  .word   6
  .word   String_dispTab
  .word   int_const3
  .ascii  "Main"
  .byte  0
  .align  2
str_const14:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const0
  .ascii  "D"
  .byte  0
  .align  2
str_const13:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const0
  .ascii  "C"
  .byte  0
  .align  2
str_const12:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const0
  .ascii  "B"
  .byte  0
  .align  2
str_const11:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const0
  .ascii  "A"
  .byte  0
  .align  2
str_const10:
  .word   5
  .word   6
  .word   String_dispTab
  .word   int_const5
  .ascii  "String"
  .byte  0
  .align  2
str_const9:
  .word   5
  .word   6
  .word   String_dispTab
  .word   int_const3
  .ascii  "Bool"
  .byte  0
  .align  2
str_const8:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const2
  .ascii  "Int"
  .byte  0
  .align  2
str_const7:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const1
  .ascii  "IO"
  .byte  0
  .align  2
str_const6:
  .word   5
  .word   6
  .word   String_dispTab
  .word   int_const5
  .ascii  "Object"
  .byte  0
  .align  2
str_const5:
  .word   5
  .word   7
  .word   String_dispTab
  .word   int_const7
  .ascii  "_prim_slot"
  .byte  0
  .align  2
str_const4:
  .word   5
  .word   7
  .word   String_dispTab
  .word   int_const8
  .ascii  "SELF_TYPE"
  .byte  0
  .align  2
str_const3:
  .word   5
  .word   7
  .word   String_dispTab
  .word   int_const8
  .ascii  "_no_class"
  .byte  0
  .align  2
str_const2:
  .word   5
  .word   8
  .word   String_dispTab
  .word   int_const9
  .ascii  "<basic class>"
  .byte  0
  .align  2
str_const1:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const0
  .ascii  "\n"
  .byte  0
  .align  2
str_const0:
  .word   5
  .word   9
  .word   String_dispTab
  .word   int_const10
  .ascii  "grading/override.cl"
  .byte  0
  .align  2
int_const10:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   19
int_const9:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   13
int_const8:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   9
int_const7:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   10
int_const6:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   0
int_const5:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   6
int_const4:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   5
int_const3:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   4
int_const2:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   3
int_const1:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   2
int_const0:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   1
bool_const0:
  .word   4
  .word   4
  .word   Bool_dispTab
  .word   0
bool_const1:
  .word   4
  .word   4
  .word   Bool_dispTab
  .word   1
class_nameTab:
  .word   str_const6
  .word   str_const7
  .word   str_const15
  .word   str_const8
  .word   str_const9
  .word   str_const10
  .word   str_const11
  .word   str_const12
  .word   str_const13
  .word   str_const14
class_objTab:
  .word   Object_protObj
  .word   Object_init
  .word   IO_protObj
  .word   IO_init
  .word   Main_protObj
  .word   Main_init
  .word   Int_protObj
  .word   Int_init
  .word   Bool_protObj
  .word   Bool_init
  .word   String_protObj
  .word   String_init
  .word   A_protObj
  .word   A_init
  .word   B_protObj
  .word   B_init
  .word   C_protObj
  .word   C_init
  .word   D_protObj
  .word   D_init
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
A_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   A.f
  .word   A.g
B_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   A.f
  .word   B.g
C_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   C.f
  .word   B.g
D_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   D.f
  .word   D.g
  .word   -1
Object_protObj:
  .word   0
  .word   3
  .word   Object_dispTab
  .word   -1
IO_protObj:
  .word   1
  .word   3
  .word   IO_dispTab
  .word   -1
Main_protObj:
  .word   2
  .word   7
  .word   Main_dispTab
  .word   0
  .word   0
  .word   0
  .word   0
  .word   -1
Int_protObj:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   0
  .word   -1
Bool_protObj:
  .word   4
  .word   4
  .word   Bool_dispTab
  .word   0
  .word   -1
String_protObj:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const6
  .word   0
  .word   -1
A_protObj:
  .word   6
  .word   3
  .word   A_dispTab
  .word   -1
B_protObj:
  .word   7
  .word   3
  .word   B_dispTab
  .word   -1
C_protObj:
  .word   8
  .word   3
  .word   C_dispTab
  .word   -1
D_protObj:
  .word   9
  .word   3
  .word   D_dispTab
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
  la    a0 A_protObj
  jal   Object.copy
  jal   A_init
  sw    a0 12(s0)
  la    a0 B_protObj
  jal   Object.copy
  jal   B_init
  sw    a0 16(s0)
  la    a0 C_protObj
  jal   Object.copy
  jal   C_init
  sw    a0 20(s0)
  la    a0 D_protObj
  jal   Object.copy
  jal   D_init
  sw    a0 24(s0)
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
A_init:
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
B_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   A_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
C_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   B_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
D_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   C_init
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
  lw    a0 12(s0)
  bne   a0 x0 label0
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label0:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label1
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label1:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 12(s0)
  bne   a0 x0 label2
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label2:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label3
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label3:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 16(s0)
  bne   a0 x0 label4
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label4:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label5
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label5:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 16(s0)
  bne   a0 x0 label6
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label6:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label7
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label7:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 20(s0)
  bne   a0 x0 label8
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label8:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label9
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label9:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 20(s0)
  bne   a0 x0 label10
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label10:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label11
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label11:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 24(s0)
  bne   a0 x0 label12
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label12:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label13
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label13:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 24(s0)
  bne   a0 x0 label14
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label14:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label15
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label15:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 12(s0)
  bne   a0 x0 label16
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label16:
  la    t1 A_dispTab
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label17
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label17:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 12(s0)
  bne   a0 x0 label18
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label18:
  la    t1 A_dispTab
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label19
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label19:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 16(s0)
  bne   a0 x0 label20
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label20:
  la    t1 A_dispTab
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label21
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label21:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 16(s0)
  bne   a0 x0 label22
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label22:
  la    t1 A_dispTab
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label23
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label23:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 20(s0)
  bne   a0 x0 label24
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label24:
  la    t1 B_dispTab
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label25
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label25:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 20(s0)
  bne   a0 x0 label26
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label26:
  la    t1 B_dispTab
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label27
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label27:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 24(s0)
  bne   a0 x0 label28
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label28:
  la    t1 C_dispTab
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label29
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label29:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 24(s0)
  bne   a0 x0 label30
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label30:
  la    t1 C_dispTab
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label31
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label31:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  la    a0 B_protObj
  jal   Object.copy
  jal   B_init
  sw    a0 12(s0)
  la    a0 C_protObj
  jal   Object.copy
  jal   C_init
  sw    a0 16(s0)
  la    a0 D_protObj
  jal   Object.copy
  jal   D_init
  sw    a0 20(s0)
  lw    a0 12(s0)
  bne   a0 x0 label32
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label32:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label33
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label33:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 12(s0)
  bne   a0 x0 label34
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label34:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label35
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label35:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 16(s0)
  bne   a0 x0 label36
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label36:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label37
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label37:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 16(s0)
  bne   a0 x0 label38
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label38:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label39
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label39:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 20(s0)
  bne   a0 x0 label40
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label40:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label41
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label41:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  lw    a0 20(s0)
  bne   a0 x0 label42
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label42:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label43
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label43:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  la    a0 str_const1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label44
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label44:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
A.f:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  la    a0 int_const0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
A.g:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  la    a0 int_const1
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
B.g:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  la    a0 int_const2
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
C.f:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  la    a0 int_const3
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
D.f:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  la    a0 int_const4
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
D.g:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  la    a0 int_const5
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   

# end of generated code
