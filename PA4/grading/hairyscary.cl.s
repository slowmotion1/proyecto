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
  .word   6
_bool_tag:
  .word   7
_string_tag:
  .word   8
  .globl  _MemMgr_TEST
_MemMgr_TEST:
  .word   0
str_const16:
  .word   8
  .word   5
  .word   String_dispTab
  .word   int_const2
  .byte  0
  .align  2
str_const15:
  .word   8
  .word   6
  .word   String_dispTab
  .word   int_const3
  .ascii  "Main"
  .byte  0
  .align  2
str_const14:
  .word   8
  .word   6
  .word   String_dispTab
  .word   int_const3
  .ascii  "Bazz"
  .byte  0
  .align  2
str_const13:
  .word   8
  .word   6
  .word   String_dispTab
  .word   int_const3
  .ascii  "Razz"
  .byte  0
  .align  2
str_const12:
  .word   8
  .word   5
  .word   String_dispTab
  .word   int_const4
  .ascii  "Bar"
  .byte  0
  .align  2
str_const11:
  .word   8
  .word   5
  .word   String_dispTab
  .word   int_const4
  .ascii  "Foo"
  .byte  0
  .align  2
str_const10:
  .word   8
  .word   6
  .word   String_dispTab
  .word   int_const5
  .ascii  "String"
  .byte  0
  .align  2
str_const9:
  .word   8
  .word   6
  .word   String_dispTab
  .word   int_const3
  .ascii  "Bool"
  .byte  0
  .align  2
str_const8:
  .word   8
  .word   5
  .word   String_dispTab
  .word   int_const4
  .ascii  "Int"
  .byte  0
  .align  2
str_const7:
  .word   8
  .word   5
  .word   String_dispTab
  .word   int_const0
  .ascii  "IO"
  .byte  0
  .align  2
str_const6:
  .word   8
  .word   6
  .word   String_dispTab
  .word   int_const5
  .ascii  "Object"
  .byte  0
  .align  2
str_const5:
  .word   8
  .word   7
  .word   String_dispTab
  .word   int_const6
  .ascii  "_prim_slot"
  .byte  0
  .align  2
str_const4:
  .word   8
  .word   7
  .word   String_dispTab
  .word   int_const7
  .ascii  "SELF_TYPE"
  .byte  0
  .align  2
str_const3:
  .word   8
  .word   7
  .word   String_dispTab
  .word   int_const7
  .ascii  "_no_class"
  .byte  0
  .align  2
str_const2:
  .word   8
  .word   8
  .word   String_dispTab
  .word   int_const8
  .ascii  "<basic class>"
  .byte  0
  .align  2
str_const1:
  .word   8
  .word   7
  .word   String_dispTab
  .word   int_const6
  .ascii  "do nothing"
  .byte  0
  .align  2
str_const0:
  .word   8
  .word   10
  .word   String_dispTab
  .word   int_const9
  .ascii  "grading/hairyscary.cl"
  .byte  0
  .align  2
int_const9:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   21
int_const8:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   13
int_const7:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   9
int_const6:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   10
int_const5:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   6
int_const4:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   3
int_const3:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   4
int_const2:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   0
int_const1:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   1
int_const0:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   2
bool_const0:
  .word   7
  .word   4
  .word   Bool_dispTab
  .word   0
bool_const1:
  .word   7
  .word   4
  .word   Bool_dispTab
  .word   1
class_nameTab:
  .word   str_const6
  .word   str_const7
  .word   str_const14
  .word   str_const11
  .word   str_const13
  .word   str_const12
  .word   str_const8
  .word   str_const9
  .word   str_const10
  .word   str_const15
class_objTab:
  .word   Object_protObj
  .word   Object_init
  .word   IO_protObj
  .word   IO_init
  .word   Bazz_protObj
  .word   Bazz_init
  .word   Foo_protObj
  .word   Foo_init
  .word   Razz_protObj
  .word   Razz_init
  .word   Bar_protObj
  .word   Bar_init
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
Bazz_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   IO.out_string
  .word   IO.out_int
  .word   IO.in_string
  .word   IO.in_int
  .word   Bazz.printh
  .word   Bazz.doh
Foo_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   IO.out_string
  .word   IO.out_int
  .word   IO.in_string
  .word   IO.in_int
  .word   Bazz.printh
  .word   Foo.doh
Razz_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   IO.out_string
  .word   IO.out_int
  .word   IO.in_string
  .word   IO.in_int
  .word   Bazz.printh
  .word   Foo.doh
Bar_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   IO.out_string
  .word   IO.out_int
  .word   IO.in_string
  .word   IO.in_int
  .word   Bazz.printh
  .word   Foo.doh
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
Main_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   Main.main
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
Bazz_protObj:
  .word   2
  .word   6
  .word   Bazz_dispTab
  .word   int_const2
  .word   0
  .word   0
  .word   -1
Foo_protObj:
  .word   3
  .word   8
  .word   Foo_dispTab
  .word   int_const2
  .word   0
  .word   0
  .word   0
  .word   int_const2
  .word   -1
Razz_protObj:
  .word   4
  .word   10
  .word   Razz_dispTab
  .word   int_const2
  .word   0
  .word   0
  .word   0
  .word   int_const2
  .word   0
  .word   int_const2
  .word   -1
Bar_protObj:
  .word   5
  .word   12
  .word   Bar_dispTab
  .word   int_const2
  .word   0
  .word   0
  .word   0
  .word   int_const2
  .word   0
  .word   int_const2
  .word   int_const2
  .word   0
  .word   -1
Int_protObj:
  .word   6
  .word   4
  .word   Int_dispTab
  .word   0
  .word   -1
Bool_protObj:
  .word   7
  .word   4
  .word   Bool_dispTab
  .word   0
  .word   -1
String_protObj:
  .word   8
  .word   5
  .word   String_dispTab
  .word   int_const2
  .word   0
  .word   -1
Main_protObj:
  .word   9
  .word   7
  .word   Main_dispTab
  .word   0
  .word   0
  .word   0
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
Bazz_init:
  addi  sp sp -16
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   IO_init
  la    a0 int_const1
  sw    a0 12(s0)
  mv    a0 s0
  bne   a0 x0 label1
  la    a0 str_const0
  li    t1 1
  jal   _case_abort2
label1:
  lw    t2 0(a0)
  li    t3 5
  blt   t2 t3 label2
  li    t3 5
  bgt   t2 t3 label2
  sw    a0 12(tp)
  lw    a0 12(tp)
  j     label0
label2:
  li    t3 4
  blt   t2 t3 label3
  li    t3 5
  bgt   t2 t3 label3
  sw    a0 12(tp)
  la    a0 Bar_protObj
  jal   Object.copy
  jal   Bar_init
  j     label0
label3:
  li    t3 3
  blt   t2 t3 label4
  li    t3 5
  bgt   t2 t3 label4
  sw    a0 12(tp)
  la    a0 Razz_protObj
  jal   Object.copy
  jal   Razz_init
  j     label0
label4:
  li    t3 2
  blt   t2 t3 label5
  li    t3 5
  bgt   t2 t3 label5
  sw    a0 12(tp)
  la    a0 Foo_protObj
  jal   Object.copy
  jal   Foo_init
  j     label0
label5:
  jal   _case_abort
label0:
  sw    a0 16(s0)
  mv    a0 s0
  bne   a0 x0 label6
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label6:
  lw    t1 8(a0)
  lw    t1 28(t1)
  jalr  t1
  sw    a0 20(s0)
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   
Foo_init:
  addi  sp sp -16
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Bazz_init
  mv    a0 s0
  bne   a0 x0 label8
  la    a0 str_const0
  li    t1 1
  jal   _case_abort2
label8:
  lw    t2 0(a0)
  li    t3 5
  blt   t2 t3 label9
  li    t3 5
  bgt   t2 t3 label9
  sw    a0 12(tp)
  lw    a0 12(tp)
  j     label7
label9:
  li    t3 4
  blt   t2 t3 label10
  li    t3 5
  bgt   t2 t3 label10
  sw    a0 12(tp)
  la    a0 Bar_protObj
  jal   Object.copy
  jal   Bar_init
  j     label7
label10:
  li    t3 3
  blt   t2 t3 label11
  li    t3 5
  bgt   t2 t3 label11
  sw    a0 12(tp)
  la    a0 Razz_protObj
  jal   Object.copy
  jal   Razz_init
  j     label7
label11:
  jal   _case_abort
label7:
  sw    a0 24(s0)
  lw    a0 24(s0)
  bne   a0 x0 label12
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label12:
  lw    t1 8(a0)
  lw    t1 32(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  lw    a0 16(s0)
  bne   a0 x0 label13
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label13:
  lw    t1 8(a0)
  lw    t1 32(t1)
  jalr  t1
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label14
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label14:
  lw    t1 8(a0)
  lw    t1 32(t1)
  jalr  t1
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label15
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label15:
  lw    t1 8(a0)
  lw    t1 28(t1)
  jalr  t1
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 28(s0)
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   
Razz_init:
  addi  sp sp -16
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Foo_init
  mv    a0 s0
  bne   a0 x0 label17
  la    a0 str_const0
  li    t1 1
  jal   _case_abort2
label17:
  lw    t2 0(a0)
  li    t3 5
  blt   t2 t3 label18
  li    t3 5
  bgt   t2 t3 label18
  sw    a0 12(tp)
  lw    a0 12(tp)
  j     label16
label18:
  li    t3 4
  blt   t2 t3 label19
  li    t3 5
  bgt   t2 t3 label19
  sw    a0 12(tp)
  la    a0 Bar_protObj
  jal   Object.copy
  jal   Bar_init
  j     label16
label19:
  jal   _case_abort
label16:
  sw    a0 32(s0)
  lw    a0 24(s0)
  bne   a0 x0 label20
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label20:
  la    t1 Bazz_dispTab
  lw    t1 32(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  lw    a0 16(s0)
  bne   a0 x0 label21
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label21:
  lw    t1 8(a0)
  lw    t1 32(t1)
  jalr  t1
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  lw    a0 32(s0)
  bne   a0 x0 label22
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label22:
  lw    t1 8(a0)
  lw    t1 32(t1)
  jalr  t1
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label23
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label23:
  lw    t1 8(a0)
  lw    t1 32(t1)
  jalr  t1
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label24
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label24:
  lw    t1 8(a0)
  lw    t1 28(t1)
  jalr  t1
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 36(s0)
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   
Bar_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Razz_init
  mv    a0 s0
  bne   a0 x0 label25
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label25:
  lw    t1 8(a0)
  lw    t1 32(t1)
  jalr  t1
  sw    a0 40(s0)
  mv    a0 s0
  bne   a0 x0 label26
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label26:
  lw    t1 8(a0)
  lw    t1 28(t1)
  jalr  t1
  sw    a0 44(s0)
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
Main_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Object_init
  la    a0 Bazz_protObj
  jal   Object.copy
  jal   Bazz_init
  sw    a0 12(s0)
  la    a0 Foo_protObj
  jal   Object.copy
  jal   Foo_init
  sw    a0 16(s0)
  la    a0 Razz_protObj
  jal   Object.copy
  jal   Razz_init
  sw    a0 20(s0)
  la    a0 Bar_protObj
  jal   Object.copy
  jal   Bar_init
  sw    a0 24(s0)
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
Bazz.printh:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  lw    a0 12(s0)
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
  la    a0 int_const2
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
Bazz.doh:
  addi  sp sp -16
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  lw    a0 12(s0)
  sw    a0 12(tp)
  lw    a0 12(s0)
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const1
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 12(s0)
  lw    a0 12(tp)
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   
Foo.doh:
  addi  sp sp -16
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  lw    a0 12(s0)
  sw    a0 12(tp)
  lw    a0 12(s0)
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const0
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 12(s0)
  lw    a0 12(tp)
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   
Main.main:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  la    a0 str_const1
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   

# end of generated code
