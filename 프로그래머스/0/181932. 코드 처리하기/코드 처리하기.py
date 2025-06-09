def solution(code):
    mode = 0
    ret = ''
    for i, c in enumerate(code):
        if mode == 0:
            if c != '1':
                if i % 2 == 0:
                    ret += c
            else: mode = 1
        else:
            if c != '1':
                if i % 2 == 1:
                    ret += c
            else : mode = 0
    return ret if ret != '' else 'EMPTY'